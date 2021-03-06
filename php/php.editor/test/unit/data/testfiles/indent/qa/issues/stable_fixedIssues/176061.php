<?php

/**
 * references actions.
 *
 * @package    twinstav
 * @subpackage references
 * @author     Filip Zamboj <bfelipee@gmail.com>
 * @version    SVN: $Id: actions.class.php 12479 2008-10-31 10:54:40Z fabien $
 */
class referencesActions extends sfActions {
    /**
     * Executes index action
     *
     * @param sfRequest $request A request object
     */
    public function executeIndex(sfWebRequest $request) {
        $this->categories_list = Doctrine::getTable("ReferencesCategory")
                ->createQuery("c")
                ->where("disabled is null")
                ->orderBy("priority ASC")
                ->execute();
    }

    public function executeShowItemDetail(sfWebRequest $request) {
        $this->item_detail = $this->getRoute()->getObject();

        $this->pager = new sfDoctrinePager('ReferencesFiles',10);
        $this->pager->getQuery()->from('ReferencesFiles c')
                ->where("c.disabled is null")
                ->andWhere("c.ref_id = ?", $this->getRoute()->getObject()->getId())
                ->orderBy("priority ASC");
        $this->pager->setPage($request->getParameter('page', 1));
        $this->pager->init();
    }

    public function executeShowCategoryDetail(sfWebRequest $request) {

        $this->pager = new sfDoctrinePager('ReferencesItems',10);
        $this->pager->getQuery()->from('ReferencesItems c')
                ->where("c.disabled is null")
                ->andWhere("c.ref_category_id = ?", $this->getRoute()->getObject()->getId())
                ->orderBy("priority ASC")^

    }
}
