(function() {
    'use strict';

    angular.module('tatami')
        .config(postConfig);

    postConfig.$inject = ['$stateProvider'];
    function postConfig($stateProvider) {
        $stateProvider
            .state('post', {
                url: '/post/:statusId',
                parent: 'tatami',
                templateUrl: 'app/components/post/post.html',
                controller: 'PostCtrl',
                controllerAs: 'vm',

                resolve: {
                    repliedToStatus: getRepliedToStatus
                }
            })
    }

    getRepliedToStatus.$inject = ['StatusService', '$stateParams'];
    function getRepliedToStatus(StatusService, $stateParams) {
        if($stateParams.statusId) {
            return StatusService.get({ statusId: $stateParams.statusId }).$promise;
        }
    }
})();
